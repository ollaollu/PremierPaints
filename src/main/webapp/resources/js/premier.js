                        //function to initialise production in new production page
                        function updateValues(){
            var qty1 = document.getElementById("productionForm:dispqtyPerPail1").value;
            var qty2 = document.getElementById("productionForm:dispqtyPerPail2").value;
            var qty3 = document.getElementById("productionForm:dispqtyPerPail3").value;
            var qty4 = document.getElementById("productionForm:dispqtyPerPail4").value;
            var qty5 = document.getElementById("productionForm:dispqtyPerPail5").value;
            var qty6 = document.getElementById("productionForm:dispqtyPerPail6").value;
            var qty7 = document.getElementById("productionForm:dispqtyPerPail7").value;
            var qty8 = document.getElementById("productionForm:dispqtyPerPail8").value;
            var qty9 = document.getElementById("productionForm:dispqtyPerPail9").value;
            var qty10 = document.getElementById("productionForm:dispqtyPerPail10").value;
            var qty11 = document.getElementById("productionForm:dispqtyPerPail11").value;
            var qty12 = document.getElementById("productionForm:dispqtyPerPail12").value;
            var qty13 = document.getElementById("productionForm:dispqtyPerPail13").value;
            var qty14 = document.getElementById("productionForm:dispqtyPerPail14").value;
            var qty15 = document.getElementById("productionForm:dispqtyPerPail15").value;
            var qty16 = document.getElementById("productionForm:dispqtyPerPail16").value;
            var qty17 = document.getElementById("productionForm:dispqtyPerPail17").value;
            var qty18 = document.getElementById("productionForm:dispqtyPerPail18").value;
            var productionName = document.getElementById("productionForm:dispcurrent").value;
            var sg = document.getElementById("productionForm:sg").value;
            //document.ge
            var code1 = document.getElementById("productionForm:dispinputCodeSelect1").value;
            var code2 = document.getElementById("productionForm:dispinputCodeSelect2").value;
            var code3 = document.getElementById("productionForm:dispinputCodeSelect3").value;
            var code4 = document.getElementById("productionForm:dispinputCodeSelect4").value;
            var code5 = document.getElementById("productionForm:dispinputCodeSelect5").value;
            var code6 = document.getElementById("productionForm:dispinputCodeSelect6").value;
            var code7 = document.getElementById("productionForm:dispinputCodeSelect7").value;
            var code8 = document.getElementById("productionForm:dispinputCodeSelect8").value;
            var code9 = document.getElementById("productionForm:dispinputCodeSelect9").value;
            var code10 = document.getElementById("productionForm:dispinputCodeSelect10").value;
            var code11 = document.getElementById("productionForm:dispinputCodeSelect11").value;
            var code12 = document.getElementById("productionForm:dispinputCodeSelect12").value;
            var code13 = document.getElementById("productionForm:dispinputCodeSelect13").value;
            var code14 = document.getElementById("productionForm:dispinputCodeSelect14").value;
            var code15 = document.getElementById("productionForm:dispinputCodeSelect15").value;
            var code16 = document.getElementById("productionForm:dispinputCodeSelect16").value;
            var code17 = document.getElementById("productionForm:dispinputCodeSelect17").value;
            var code18 = document.getElementById("productionForm:dispinputCodeSelect18").value;
            //alert(qty12.value);
            if(qty1 === null||qty2 === null||qty3 === null||qty4 === null||qty5 === null||qty6 === null||qty7 === null||qty8 === null||qty9 === null||qty10 === null||qty11 === null||qty12 === null||qty13 === null||qty14 === null||qty15 === null||qty16 === null||qty17 === null||qty18 === null){
            qty1 = 0.0;
            qty2 = 0.0;
            qty3 = 0.0;
            qty4 = 0.0;
            qty5 = 0.0;
            qty6 = 0.0;
            qty7 = 0.0;
            qty8 = 0.0;
            qty9 = 0.0;
            qty10 = 0.0;
            qty11 = 0.0;
            qty12 = 0.0;
            qty13 = 0.0;
            qty14 = 0.0;
            qty15 = 0.0;
            qty16 = 0.0;
            qty17 = 0.0;
            qty18 = 0.0;
            }else {
                        document.getElementById("productionForm:qtyPerPail1").value = qty1;
                        document.getElementById("productionForm:qtyPerPail2").value = qty2;
                        document.getElementById("productionForm:qtyPerPail3").value = qty3;
                        document.getElementById("productionForm:qtyPerPail4").value = qty4;
                        document.getElementById("productionForm:qtyPerPail5").value = qty5;
                        document.getElementById("productionForm:qtyPerPail6").value = qty6;
                        document.getElementById("productionForm:qtyPerPail7").value = qty7;
                        document.getElementById("productionForm:qtyPerPail8").value = qty8;
                        document.getElementById("productionForm:qtyPerPail9").value = qty9;
                        document.getElementById("productionForm:qtyPerPail10").value = qty10;
            		document.getElementById("productionForm:qtyPerPail11").value = qty11;
            		document.getElementById("productionForm:qtyPerPail12").value = qty12;
                        document.getElementById("productionForm:qtyPerPail13").value = qty13;
                        document.getElementById("productionForm:qtyPerPail14").value = qty14;
                        document.getElementById("productionForm:qtyPerPail15").value = qty15;
                        document.getElementById("productionForm:qtyPerPail16").value = qty16;
                        document.getElementById("productionForm:qtyPerPail17").value = qty17;
                        document.getElementById("productionForm:qtyPerPail18").value = qty18;                        
            }
                        document.getElementById("productionForm:atmcurrent").value = productionName;
                        document.getElementById("productionForm:sgcurrent").value = sg;
                        //document.getElementByID("productionForm:atmcurrent").value = productionName;
                        document.getElementById("productionForm:inputCodeSelect1").value = code1;
                        document.getElementById("productionForm:inputCodeSelect2").value = code2;
                        document.getElementById("productionForm:inputCodeSelect3").value = code3;
                        document.getElementById("productionForm:inputCodeSelect4").value = code4;
                        document.getElementById("productionForm:inputCodeSelect5").value = code5;
                        document.getElementById("productionForm:inputCodeSelect6").value = code6;
                        document.getElementById("productionForm:inputCodeSelect7").value = code7;
                        document.getElementById("productionForm:inputCodeSelect8").value = code8;
                        document.getElementById("productionForm:inputCodeSelect9").value = code9;
                        document.getElementById("productionForm:inputCodeSelect10").value = code10;
                        document.getElementById("productionForm:inputCodeSelect11").value = code11;
                        document.getElementById("productionForm:inputCodeSelect12").value = code12;
                        document.getElementById("productionForm:inputCodeSelect13").value = code13;
                        document.getElementById("productionForm:inputCodeSelect14").value = code14;
                        document.getElementById("productionForm:inputCodeSelect15").value = code15;
                        document.getElementById("productionForm:inputCodeSelect16").value = code16;
                        document.getElementById("productionForm:inputCodeSelect17").value = code17;
                        document.getElementById("productionForm:inputCodeSelect18").value = code18;
            
            //alert('Production Initialised.. Click Ok to Proceed');
        }
        
                function calcValues(){
            var qty = document.getElementById("productionForm:requiredQty").value;
            var qtyPail1 = document.getElementById("productionForm:qtyPerPail1").value;            
            var qtyPail2 = document.getElementById("productionForm:qtyPerPail2").value;
            var qtyPail3 = document.getElementById("productionForm:qtyPerPail3").value;
            var qtyPail4 = document.getElementById("productionForm:qtyPerPail4").value;
            var qtyPail5 = document.getElementById("productionForm:qtyPerPail5").value;
            var qtyPail6 = document.getElementById("productionForm:qtyPerPail6").value;
            var qtyPail7 = document.getElementById("productionForm:qtyPerPail7").value;
            var qtyPail8 = document.getElementById("productionForm:qtyPerPail8").value;
            var qtyPail9 = document.getElementById("productionForm:qtyPerPail9").value;
            var qtyPail10 = document.getElementById("productionForm:qtyPerPail10").value;
            var qtyPail11 = document.getElementById("productionForm:qtyPerPail11").value;
            var qtyPail12 = document.getElementById("productionForm:qtyPerPail12").value;
            var qtyPail13 = document.getElementById("productionForm:qtyPerPail13").value;
            var qtyPail14 = document.getElementById("productionForm:qtyPerPail14").value;
            var qtyPail15 = document.getElementById("productionForm:qtyPerPail15").value;
            var qtyPail16 = document.getElementById("productionForm:qtyPerPail16").value;
            var qtyPail17 = document.getElementById("productionForm:qtyPerPail17").value;
            var qtyPail18 = document.getElementById("productionForm:qtyPerPail18").value;
            var add1 = document.getElementById("productionForm:additionalQty1").value;
            var add2 = document.getElementById("productionForm:additionalQty2").value;
            var add3 = document.getElementById("productionForm:additionalQty3").value;
            var add4 = document.getElementById("productionForm:additionalQty4").value;
            var add5 = document.getElementById("productionForm:additionalQty5").value;
            var add6 = document.getElementById("productionForm:additionalQty6").value;
            var add7 = document.getElementById("productionForm:additionalQty7").value;
            var add8 = document.getElementById("productionForm:additionalQty8").value;
            var total1 = (parseInt(qty)*qtyPail1);
            var total2 = (parseInt(qty)*qtyPail2);
            var total3 = (parseInt(qty)*qtyPail3);
            var total4 = (parseInt(qty)*qtyPail4);
            var total5 = (parseInt(qty)*qtyPail5);
            var total6 = (parseInt(qty)*qtyPail6);
            var total7 = (parseInt(qty)*qtyPail7);
            var total8 = (parseInt(qty)*qtyPail8);
            var total9 = (parseInt(qty)*qtyPail9);
            var total10 = (parseInt(qty)*qtyPail10);
            var total11 = (parseInt(qty)*qtyPail11);
            var total12 = (parseInt(qty)*qtyPail12);
            var total13 = (parseInt(qty)*qtyPail13);
            var total14 = (parseInt(qty)*qtyPail14);
            var total15 = (parseInt(qty)*qtyPail15);
            var total16 = (parseInt(qty)*qtyPail16);
            var total17 = (parseInt(qty)*qtyPail17);
            var total18 = (parseInt(qty)*qtyPail18);
            var totalAdd1 = (parseInt(qty)*add1);
            var totalAdd2 = (parseInt(qty)*add2);
            var totalAdd3 = (parseInt(qty)*add3);
            var totalAdd4 = (parseInt(qty)*add4);
            var totalAdd5 = (parseInt(qty)*add5);
            var totalAdd6 = (parseInt(qty)*add6);
            var totalAdd7 = (parseInt(qty)*add7);
            var totalAdd8 = (parseInt(qty)*add8);
            //alert(qty.value);
            document.getElementById("productionForm:productionQty1").value = total1;
            document.getElementById("productionForm:productionQty2").value = total2;
            document.getElementById("productionForm:productionQty3").value = total3;
            document.getElementById("productionForm:productionQty4").value = total4;
            document.getElementById("productionForm:productionQty5").value = total5;
            document.getElementById("productionForm:productionQty6").value = total6;
            document.getElementById("productionForm:productionQty7").value = total7;
            document.getElementById("productionForm:productionQty8").value = total8;
            document.getElementById("productionForm:productionQty9").value = total9;
            document.getElementById("productionForm:productionQty10").value = total10;
            document.getElementById("productionForm:productionQty11").value = total11;
            document.getElementById("productionForm:productionQty12").value = total12;
            document.getElementById("productionForm:productionQty13").value = total13;
            document.getElementById("productionForm:productionQty14").value = total14;
            document.getElementById("productionForm:productionQty15").value = total15;
            document.getElementById("productionForm:productionQty16").value = total16;
            document.getElementById("productionForm:productionQty17").value = total17;
            document.getElementById("productionForm:productionQty18").value = total18;
            document.getElementById("productionForm:additionalProQty1").value = totalAdd1;
            document.getElementById("productionForm:additionalProQty2").value = totalAdd2;
            document.getElementById("productionForm:additionalProQty3").value = totalAdd3;
            document.getElementById("productionForm:additionalProQty4").value = totalAdd4;
            document.getElementById("productionForm:additionalProQty5").value = totalAdd5;
            document.getElementById("productionForm:additionalProQty6").value = totalAdd6;
            document.getElementById("productionForm:additionalProQty7").value = totalAdd7;
            document.getElementById("productionForm:additionalProQty8").value = totalAdd8;
        }
      //function for the radio buttons in production page for pails, gallons, drums and auto calculation
      function reactToChangedRadio(){
      var myval;
      var sg = document.getElementById("productionForm:sg").value;
        if(document.forms['productionForm']['productionForm:myRadio'][0].checked === true ){
          //Gallons
          var sqty1 = $("#productionForm\\:productionQty1").val();
          var sqty2 = $("#productionForm\\:productionQty2").val();
          var sqty3 = $("#productionForm\\:productionQty3").val();
          var sqty4 = $("#productionForm\\:productionQty4").val();
          var sqty5 = $("#productionForm\\:productionQty5").val();
          var sqty6 = $("#productionForm\\:productionQty6").val();
          var sqty7 = $("#productionForm\\:productionQty7").val();
          var sqty8 = $("#productionForm\\:productionQty8").val();
          var sqty9 = $("#productionForm\\:productionQty9").val();
          var sqty10 = $("#productionForm\\:productionQty10").val();
          var sqty11 = $("#productionForm\\:productionQty11").val();
          var sqty12 = $("#productionForm\\:productionQty12").val();
          var sqty13 = $("#productionForm\\:productionQty13").val();
          var sqty14 = $("#productionForm\\:productionQty14").val();
          var sqty15 = $("#productionForm\\:productionQty15").val();
          var sqty16 = $("#productionForm\\:productionQty16").val();
          var sqty17 = $("#productionForm\\:productionQty17").val();
          var sqty18 = $("#productionForm\\:productionQty18").val();
          var sqty19 = $("#productionForm\\:additionalProQty1").val();
          var sqty20 = $("#productionForm\\:additionalProQty2").val();
          var sqty21 = $("#productionForm\\:additionalProQty3").val();
          var sqty22 = $("#productionForm\\:additionalProQty4").val();
          var sqty23 = $("#productionForm\\:additionalProQty5").val();
          var sqty24 = $("#productionForm\\:additionalProQty6").val();
          var sqty25 = $("#productionForm\\:additionalProQty7").val();
          var sqty26 = $("#productionForm\\:additionalProQty8").val();
          var sumQty = (+sqty1 + +sqty2 + +sqty3 + +sqty4 + +sqty5 + +sqty6 + +sqty7 + +sqty8 + +sqty9 + +sqty10 + +sqty11 + +sqty12 + +sqty13 + +sqty14 + +sqty15 + +sqty16 + +sqty17 + +sqty18 + +sqty19 + +sqty20 + +sqty21 + +sqty22 + +sqty23 + +sqty24 + +sqty25 + +sqty26);
          var holderValue = (sumQty/sg)/4;
          //myval = holderValue.toFixed(2);
          myval = Math.round(holderValue);
          document.getElementById("productionForm:requiredQty").value = myval;
        }else if(document.forms['productionForm']['productionForm:myRadio'][1].checked === true ){
            //Pails
          var sqty1 = $("#productionForm\\:productionQty1").val();
          var sqty2 = $("#productionForm\\:productionQty2").val();
          var sqty3 = $("#productionForm\\:productionQty3").val();
          var sqty4 = $("#productionForm\\:productionQty4").val();
          var sqty5 = $("#productionForm\\:productionQty5").val();
          var sqty6 = $("#productionForm\\:productionQty6").val();
          var sqty7 = $("#productionForm\\:productionQty7").val();
          var sqty8 = $("#productionForm\\:productionQty8").val();
          var sqty9 = $("#productionForm\\:productionQty9").val();
          var sqty10 = $("#productionForm\\:productionQty10").val();
          var sqty11 = $("#productionForm\\:productionQty11").val();
          var sqty12 = $("#productionForm\\:productionQty12").val();
          var sqty13 = $("#productionForm\\:productionQty13").val();
          var sqty14 = $("#productionForm\\:productionQty14").val();
          var sqty15 = $("#productionForm\\:productionQty15").val();
          var sqty16 = $("#productionForm\\:productionQty16").val();
          var sqty17 = $("#productionForm\\:productionQty17").val();
          var sqty18 = $("#productionForm\\:productionQty18").val();
          var sqty19 = $("#productionForm\\:additionalProQty1").val();
          var sqty20 = $("#productionForm\\:additionalProQty2").val();
          var sqty21 = $("#productionForm\\:additionalProQty3").val();
          var sqty22 = $("#productionForm\\:additionalProQty4").val();
          var sqty23 = $("#productionForm\\:additionalProQty5").val();
          var sqty24 = $("#productionForm\\:additionalProQty6").val();
          var sqty25 = $("#productionForm\\:additionalProQty7").val();
          var sqty26 = $("#productionForm\\:additionalProQty8").val();
          var sumQty = (+sqty1 + +sqty2 + +sqty3 + +sqty4 + +sqty5 + +sqty6 + +sqty7 + +sqty8 + +sqty9 + +sqty10 + +sqty11 + +sqty12 + +sqty13 + +sqty14 + +sqty15 + +sqty16 + +sqty17 + +sqty18 + +sqty19 + +sqty20 + +sqty21 + +sqty22 + +sqty23 + +sqty24 + +sqty25 + +sqty26);
          var holderValue = (sumQty/sg)/20;
          //myval = holderValue.toFixed(2);
          myval = Math.round(holderValue);
          document.getElementById("productionForm:requiredQty").value = myval;
        }else if(document.forms['productionForm']['productionForm:myRadio'][2].checked === true ){
            //Drum
          var sqty1 = $("#productionForm\\:productionQty1").val();
          var sqty2 = $("#productionForm\\:productionQty2").val();
          var sqty3 = $("#productionForm\\:productionQty3").val();
          var sqty4 = $("#productionForm\\:productionQty4").val();
          var sqty5 = $("#productionForm\\:productionQty5").val();
          var sqty6 = $("#productionForm\\:productionQty6").val();
          var sqty7 = $("#productionForm\\:productionQty7").val();
          var sqty8 = $("#productionForm\\:productionQty8").val();
          var sqty9 = $("#productionForm\\:productionQty9").val();
          var sqty10 = $("#productionForm\\:productionQty10").val();
          var sqty11 = $("#productionForm\\:productionQty11").val();
          var sqty12 = $("#productionForm\\:productionQty12").val();
          var sqty13 = $("#productionForm\\:productionQty13").val();
          var sqty14 = $("#productionForm\\:productionQty14").val();
          var sqty15 = $("#productionForm\\:productionQty15").val();
          var sqty16 = $("#productionForm\\:productionQty16").val();
          var sqty17 = $("#productionForm\\:productionQty17").val();
          var sqty18 = $("#productionForm\\:productionQty18").val();
          var sqty19 = $("#productionForm\\:additionalProQty1").val();
          var sqty20 = $("#productionForm\\:additionalProQty2").val();
          var sqty21 = $("#productionForm\\:additionalProQty3").val();
          var sqty22 = $("#productionForm\\:additionalProQty4").val();
          var sqty23 = $("#productionForm\\:additionalProQty5").val();
          var sqty24 = $("#productionForm\\:additionalProQty6").val();
          var sqty25 = $("#productionForm\\:additionalProQty7").val();
          var sqty26 = $("#productionForm\\:additionalProQty8").val();
          var sumQty = (+sqty1 + +sqty2 + +sqty3 + +sqty4 + +sqty5 + +sqty6 + +sqty7 + +sqty8 + +sqty9 + +sqty10 + +sqty11 + +sqty12 + +sqty13 + +sqty14 + +sqty15 + +sqty16 + +sqty17 + +sqty18 + +sqty19 + +sqty20 + +sqty21 + +sqty22 + +sqty23 + +sqty24 + +sqty25 + +sqty26);
          var holderValue = (sumQty/sg)/200;
          //myval = holderValue.toFixed(2);
          myval = Math.round(holderValue);
          document.getElementById("productionForm:requiredQty").value = myval;
        }else if(document.forms['productionForm']['productionForm:myRadio'][3].checked === true ){
            //Auto-calculate
          var qty = document.getElementById("productionForm:requiredQty").value;
          //1
          var sqty1 = document.getElementById("productionForm:qtyPerPail1").value;
          if(sqty1 !== ""){
          var total1 = qty*sqty1;
          document.getElementById("productionForm:productionQty1").value = total1;
          }
          //2
          var sqty2 = document.getElementById("productionForm:qtyPerPail2").value;
          if(sqty2 !== ""){
          var total2 = qty*sqty2;
          document.getElementById("productionForm:productionQty2").value = total2;
          }
          //3
          var sqty3 = document.getElementById("productionForm:qtyPerPail3").value;
          if(sqty3 !== ""){
          var total3 = qty*sqty3;
          document.getElementById("productionForm:productionQty3").value = total3;
          }
          //4
          var sqty4 = document.getElementById("productionForm:qtyPerPail4").value;
          if(sqty4 !== ""){
          var total4 = qty*sqty4;
          document.getElementById("productionForm:productionQty4").value = total4;
          }
          //5
          var sqty5 = document.getElementById("productionForm:qtyPerPail5").value;
          if(sqty5 !== ""){
          var total5 = qty*sqty5;
          document.getElementById("productionForm:productionQty5").value = total5;
          }
          //6
          var sqty6 = document.getElementById("productionForm:qtyPerPail6").value;
          if(sqty6 !== ""){
          var total6 = qty*sqty6;
          document.getElementById("productionForm:productionQty6").value = total6;
          }
          //7
          var sqty7 = document.getElementById("productionForm:qtyPerPail7").value;
          if(sqty7 !== ""){
          var total7 = qty*sqty7;
          document.getElementById("productionForm:productionQty7").value = total7;
          }
          //8
          var sqty8 = document.getElementById("productionForm:qtyPerPail8").value;
          if(sqty8 !== ""){
          var total8 = qty*sqty8;
          document.getElementById("productionForm:productionQty8").value = total8;
          }
          //9
          var sqty9 = document.getElementById("productionForm:qtyPerPail9").value;
          if(sqty9 !== ""){
          var total9 = qty*sqty9;
          document.getElementById("productionForm:productionQty9").value = total9;
          }
          //10
          var sqty10 = document.getElementById("productionForm:qtyPerPail10").value;
          if(sqty10 !== ""){
          var total10 = qty*sqty10;
          document.getElementById("productionForm:productionQty10").value = total10;
          }          
          //11
          var sqty11 = document.getElementById("productionForm:qtyPerPail11").value;
          if(sqty11 !== ""){
          var total11 = qty*sqty11;
          document.getElementById("productionForm:productionQty11").value = total11;
          }          
          //12
          var sqty12 = document.getElementById("productionForm:qtyPerPail12").value;
          if(sqty12 !== ""){
          var total12 = qty*sqty12;
          document.getElementById("productionForm:productionQty12").value = total12;
          }
          //13
          var sqty13 = document.getElementById("productionForm:qtyPerPail13").value;
          if(sqty13 !== ""){
          var total13 = qty*sqty13;
          document.getElementById("productionForm:productionQty13").value = total13;
          }
          //14
          var sqty14 = document.getElementById("productionForm:qtyPerPail14").value;
          if(sqty14 !== ""){
          var total14 = qty*sqty14;
          document.getElementById("productionForm:productionQty14").value = total14;
          }
          //15
          var sqty15 = document.getElementById("productionForm:qtyPerPail15").value;
          if(sqty15 !== ""){
          var total15 = qty*sqty15;
          document.getElementById("productionForm:productionQty15").value = total15;
          }
          //16
          var sqty16 = document.getElementById("productionForm:qtyPerPail16").value;
          if(sqty16 !== ""){
          var total16 = qty*sqty16;
          document.getElementById("productionForm:productionQty16").value = total16;
          }
          //17
          var sqty17 = document.getElementById("productionForm:qtyPerPail17").value;
          if(sqty17 !== ""){
          var total17 = qty*sqty17;
          document.getElementById("productionForm:productionQty17").value = total17;
          }
          //18
          var sqty18 = document.getElementById("productionForm:qtyPerPail18").value;
          if(sqty18 !== ""){
          var total18 = qty*sqty18;
          document.getElementById("productionForm:productionQty18").value = total18;
          }        
        }
        
        
        } 
        //fucntion to add old stock and new stock in update stock page
        function calculateReceived(){
            var balance = document.getElementById("updateForm:oldstockbalance").value;
            var receieved = document.getElementById("updateForm:receivedqty").value;
            var total = +balance + +receieved;
            document.getElementById("updateForm:newstockbalance").value = total;
        }
        //function for the additional calculating in editproduction page
        function calculateProductionAddition(){
            var addQty1 = $("#productionForm\\:addition1").val();
            var addTo1 = document.getElementById("productionForm:productionQty1").defaultValue;
            if(addTo1 !== ""){             
            var newVal1 = +addQty1 + +addTo1;
            document.getElementById("productionForm:productionQty1").value = newVal1;
        }
            
            var addQty2 = $("#productionForm\\:addition2").val();
            var addTo2 = document.getElementById("productionForm:productionQty2").defaultValue;
            if(addTo2 !== ""){             
            var newVal2 = +addQty2 + +addTo2;
            document.getElementById("productionForm:productionQty2").value = newVal2;
        }
            
            var addQty3 = $("#productionForm\\:addition3").val();
            var addTo3 = document.getElementById("productionForm:productionQty3").defaultValue;
            if(addTo3 !== ""){             
            var newVal3 = +addQty3 + +addTo3;
            document.getElementById("productionForm:productionQty3").value = newVal3;
        }
            
            var addQty4 = $("#productionForm\\:addition4").val();
            var addTo4 = document.getElementById("productionForm:productionQty4").defaultValue;
            if(addTo4 !== ""){             
            var newVal4 = +addQty4 + +addTo4;
            document.getElementById("productionForm:productionQty4").value = newVal4;
        }
            
            var addQty5 = $("#productionForm\\:addition5").val();
            var addTo5 = document.getElementById("productionForm:productionQty5").defaultValue;
            if(addTo5 !== ""){             
            var newVal5 = +addQty5 + +addTo5;
            document.getElementById("productionForm:productionQty5").value = newVal5;
        }
            
            var addQty6 = $("#productionForm\\:addition6").val();
            var addTo6 = document.getElementById("productionForm:productionQty6").defaultValue;
            if(addTo6 !== ""){             
            var newVal6 = +addQty6 + +addTo6;
            document.getElementById("productionForm:productionQty6").value = newVal6;
        }
            
            var addQty7 = $("#productionForm\\:addition7").val();
            var addTo7 = document.getElementById("productionForm:productionQty7").defaultValue;
            if(addTo7 !== ""){             
            var newVal7 = +addQty7 + +addTo7;
            document.getElementById("productionForm:productionQty7").value = newVal7;
        }
            
            var addQty8 = $("#productionForm\\:addition8").val();
            var addTo8 = document.getElementById("productionForm:productionQty8").defaultValue;
            if(addTo8 !== ""){             
            var newVal8 = +addQty8 + +addTo8;
            document.getElementById("productionForm:productionQty8").value = newVal8;
        }
            
            var addQty9 = $("#productionForm\\:addition9").val();
            var addTo9 = document.getElementById("productionForm:productionQty9").defaultValue;
            if(addTo9 !== ""){             
            var newVal9 = +addQty9 + +addTo9;
            document.getElementById("productionForm:productionQty9").value = newVal9;
        }
            
            var addQty10 = $("#productionForm\\:addition10").val();
            var addTo10 = document.getElementById("productionForm:productionQty10").defaultValue;
            if(addTo10 !== ""){             
            var newVal10 = +addQty10 + +addTo10;
            document.getElementById("productionForm:productionQty10").value = newVal10;
        }
            
            var addQty11 = $("#productionForm\\:addition11").val();
            var addTo11 = document.getElementById("productionForm:productionQty11").defaultValue;
            if(addTo11 !== ""){             
            var newVal11 = +addQty11 + +addTo11;
            document.getElementById("productionForm:productionQty11").value = newVal11;
        }
            
            var addQty12 = $("#productionForm\\:addition12").val();
            var addTo12 = document.getElementById("productionForm:productionQty12").defaultValue;
            if(addTo12 !== ""){             
            var newVal12 = +addQty12 + +addTo12;
            document.getElementById("productionForm:productionQty12").value = newVal12;
        }
            
            var addQty13 = $("#productionForm\\:addition13").val();
            var addTo13 = document.getElementById("productionForm:productionQty13").defaultValue;
            if(addTo13 !== ""){             
            var newVal13 = +addQty13 + +addTo13;
            document.getElementById("productionForm:productionQty13").value = newVal13;
        }
            
            var addQty14 = $("#productionForm\\:addition14").val();
            var addTo14 = document.getElementById("productionForm:productionQty14").defaultValue;
            if(addTo14 !== ""){             
            var newVal14 = +addQty14 + +addTo14;
            document.getElementById("productionForm:productionQty14").value = newVal14;
        }
            
            var addQty15 = $("#productionForm\\:addition15").val();
            var addTo15 = document.getElementById("productionForm:productionQty15").defaultValue;
            if(addTo15 !== ""){             
            var newVal15 = +addQty15 + +addTo15;
            document.getElementById("productionForm:productionQty15").value = newVal15;
        }
            
            var addQty16 = $("#productionForm\\:addition16").val();
            var addTo16 = document.getElementById("productionForm:productionQty16").defaultValue;
            if(addTo16 !== ""){             
            var newVal16 = +addQty16 + +addTo16;
            document.getElementById("productionForm:productionQty16").value = newVal16;
        }
            
            var addQty17 = $("#productionForm\\:addition17").val();
            var addTo17 = document.getElementById("productionForm:productionQty17").defaultValue;
            if(addTo17 !== ""){             
            var newVal17 = +addQty17 + +addTo17;
            document.getElementById("productionForm:productionQty17").value = newVal17;
        }
            
            var addQty18 = $("#productionForm\\:addition18").val();
            var addTo18 = document.getElementById("productionForm:productionQty18").defaultValue;
            if(addTo18 !== ""){             
            var newVal18 = +addQty18 + +addTo18;
            document.getElementById("productionForm:productionQty18").value = newVal18;
        }
            
            var addQty21 = $("#productionForm\\:addition19").val();
            var addTo21 = document.getElementById("productionForm:additionalProQty1").defaultValue;
            if(addTo21 !== ""){             
            var newVal21 = +addQty21 + +addTo21;
            document.getElementById("productionForm:additionalProQty1").value = newVal21;
        }
            
            var addQty22 = $("#productionForm\\:addition20").val();
            var addTo22 = document.getElementById("productionForm:additionalProQty2").defaultValue;
            if(addTo22 !== ""){             
            var newVal22 = +addQty22 + +addTo22;
            document.getElementById("productionForm:additionalProQty2").value = newVal22;
        }
            
            var addQty23 = $("#productionForm\\:addition21").val();
            var addTo23 = document.getElementById("productionForm:additionalProQty3").defaultValue;
            if(addTo23 !== ""){            
            var newVal23 = +addQty23 + +addTo23;
            document.getElementById("productionForm:additionalProQty3").value = newVal23;
        }
        
            var addQty24 = $("#productionForm\\:addition22").val();
            var addTo24 = document.getElementById("productionForm:additionalProQty4").defaultValue;
            if(addTo24 !== ""){            
            var newVal24 = +addQty24 + +addTo24;
            document.getElementById("productionForm:additionalProQty4").value = newVal24;
        }
        
            var addQty25 = $("#productionForm\\:addition23").val();
            var addTo25 = document.getElementById("productionForm:additionalProQty5").defaultValue;
            if(addTo25 !== ""){            
            var newVal25 = +addQty25 + +addTo25;
            document.getElementById("productionForm:additionalProQty5").value = newVal25;
        }
        
            var addQty26 = $("#productionForm\\:addition24").val();
            var addTo26 = document.getElementById("productionForm:additionalProQty6").defaultValue;
            if(addTo26 !== ""){            
            var newVal26 = +addQty26 + +addTo26;
            document.getElementById("productionForm:additionalProQty6").value = newVal26;
        }
        
            var addQty27 = $("#productionForm\\:addition25").val();
            var addTo27 = document.getElementById("productionForm:additionalProQty7").defaultValue;
            if(addTo27 !== ""){            
            var newVal27 = +addQty27 + +addTo27;
            document.getElementById("productionForm:additionalProQty7").value = newVal27;
        }
        
            var addQty28 = $("#productionForm\\:addition26").val();
            var addTo28 = document.getElementById("productionForm:additionalProQty8").defaultValue;
            if(addTo28 !== ""){            
            var newVal28 = +addQty28 + +addTo28;
            document.getElementById("productionForm:additionalProQty8").value = newVal28;
        }        
        }        
        //function to update dropdown in updatestock page
        function updateStockValues(){
            document.getElementById("updateForm:oldstockbalance").value = document.getElementById("updateForm:hiddenoldbalance").value;

            var okay = document.getElementById("updateForm:rawmaterialcode");
            var tempt = okay.options[okay.selectedIndex].value;
            document.getElementById("updateForm:hiddenname").value = tempt;
            //alert(tempt);
        }
