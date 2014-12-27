package com.application.premierpaints.util;

import java.security.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This JSF/CDI Managed Bean provides a way for users to log out of the
 * application.
 */
@Named(value = "authBean")
@RequestScoped
public class AuthBean
{
        private PremierConnection conman = null;
        private BaseSessionListener bsl = null;
        private String username;
        private String password;        

    // Built in logging is used now, but will be replaced in future with
    // 3rd party solution. Logging does what System.out.println() does and
    // more!
    private static Logger log = Logger.getLogger(AuthBean.class.getName());

    public String login(){
  
           HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()  
                                              .getExternalContext().getRequest();  
              
           try {  
                request.login(username, password);   
               try {
                   logUserLogin();
               } catch (SQLException ex) {
                   Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
               }
           } catch (ServletException e) {  
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login failed: Wrong username or password combination!", null));  
                return "Login.xhtml";  
           }  
              
           //you can fetch user from database for authenticated principal and do some action  
           Principal principal = request.getUserPrincipal();
           request.getSession().setAttribute("loggedInUser", username);
           log.log(Level.INFO, "Authenticated user: {0}", principal.getName());  
              
              
           if(request.isUserInRole("admin")) {  
                return "/Protected/Pages/LandingPage.xhtml";  
           } else {  
                return "/Protected/Pages/Users/Production.xhtml";  
           }  
      } 

    
    public String logout()
      {
        // Notice the redirect syntax. The forward slash means start at
        // the root of the web application.
        String destination = "/Protected/Pages/Login?faces-redirect=true";

        // FacesContext provides access to other container managed objects,
        // such as the HttpServletRequest object, which is needed to perform
        // the logout operation.
        //FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request
                = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        try
            {       
                    //user logout persist to database
                    try {
                        // added May 12, 2014
                        logUserLogout();                        
                    } catch (SQLException ex) {
                        Logger.getLogger(AuthBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    

            // this does not invalidate the session but does null out the user Principle
            request.logout();
            //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
            HttpSession session = request.getSession();
            session.invalidate();
            } catch (ServletException e)
            {
            log.log(Level.SEVERE, "Failed to logout user!", e);
            destination = "/Protected/Pages/LoginError?faces-redirect=true";
            }

        return destination; // go to destination
      }
    
    
    
    public void logUserLogout() throws SQLException{
            conman = new PremierConnection();
            bsl = new BaseSessionListener();
            String sql = "UPDATE useraccess SET logout = ? WHERE id = ?";
            Connection conn = null;
            PreparedStatement stm = null;
            //String user = bsl.remoteUser();
            //String userSession = bsl.userSession();
            int id = selectIdForSession();

            java.util.Date now = new java.util.Date();
            Timestamp logoutDate = new Timestamp(now.getTime());
            
        try {
            conn = conman.getDBConnection();
            stm = conn.prepareStatement(sql);
            stm.setTimestamp(1, logoutDate);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            JsfUtil.addErrorMessage("Error logging out");
        }finally
        {
          if (stm != null) {
            stm.close();
          }
          if (conn != null) {
            conn.close();
          }
        }
    }
    
    public void logUserLogin() throws SQLException{
            conman = new PremierConnection();
            bsl = new BaseSessionListener();
            String sql = "insert into useraccess (username, login, sessionid) values (?, ?, ?)";
            Connection conn = null;
            PreparedStatement stm = null;
            String user = bsl.remoteUser();
            String userSession = bsl.userSession();

            java.util.Date now = new java.util.Date();
            Timestamp loginDate = new Timestamp(now.getTime());
            
        try {
            conn = conman.getDBConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, user);
            stm.setTimestamp(2, loginDate);
            stm.setString(3, userSession);
            stm.execute();
        } catch (SQLException e) {
            JsfUtil.addErrorMessage("Error logging User on login");
        }finally
        {
          if (stm != null) {
            stm.close();
          }
          if (conn != null) {
            conn.close();
          }
        }
    } 
    
    public int selectIdForSession() throws SQLException{
            conman = new PremierConnection();
            String sql = "select id from useraccess where sessionid = ?";
            Connection conn = null;
            PreparedStatement stm = null;
            String userSession = bsl.userSession();
            int id = 0;

            try {
                conn = conman.getDBConnection();
                stm = conn.prepareStatement(sql);
                stm.setString(1, userSession);
String output = MessageFormat.format("{0}", userSession);
                            System.out.println(output);                
                
                ResultSet rs = stm.executeQuery();
                
                while (rs.next()) {                    
                    id = rs.getInt("id");
                    
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JsfUtil.addErrorMessage("Error fetching value");
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }            
            return id;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
