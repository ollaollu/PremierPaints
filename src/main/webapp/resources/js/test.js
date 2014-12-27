        jo.filter(function (i, v) {
    var $t = $(this);
    for (var d = 0; d < data.length; ++d) {
        if ($t.is(":contains('" + data[d] + "')")) {
            return true;
        }
    }
    return false;
})
//show the rows that match.
.show();