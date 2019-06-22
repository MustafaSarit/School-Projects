//Old syntax: $(document).delegate('#page1', 'pagecreate', function(event) { 
$(document).on("pagecreate", "#page1", function(event) { 
// Page1 has been created and inputs exist        
      $("#greeting").click(function(e) {
        if ($("#fullName").val() === undefined || $("#fullName").val() === "") {
            e.preventDefault();
            alert("You did not fill your name!");     
        } else {  
          $("#greet_text").text("Greetings, " + $("#fullName").val() + '!');
        }
      }
    ); }
);


