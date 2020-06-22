$(document).ready(function() {
    $("#selectEdo").change(function() {
        sendAjaxRequest();
    });
    
    getDatosConsultorio();
});

(function ($) {
    "use strict";

    
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }


})(jQuery);

function sendAjaxRequest() {		
    var country = $("#selectEdo").val();
    $.get( "/segundocombo/" + country, function(data) {
        $("#idMunicipio").empty();
        console.log(data);
        
        data.forEach(function(item, i) {
            var option = "<option  value = " + item.idMunicipio + ">" + item.nomMun +  "</option>";
            $("#idMunicipio").append(option);
        });
    });
};

function getDatosConsultorio() {		
    var id = $("#idDoctor").val();
    $.get( "/datosConsultorio/" + id, function(data) {
        $("#idDoctor").empty();
        console.log(data);
        
        data.forEach(function(item, i) {
            var option = "<label>"+ "Consultorio ubicado en " + item.nomCab +" - "+ item.nomMun + "</label>";
            $("#datosC").append(option);
        });
    });
};