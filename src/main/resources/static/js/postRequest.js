$(document).ready(function(){
	
	var url=window.location;
	
	$("#contact").submit(function(event){
		event.preventDefault();
		ajaxPost();
		
	});
	
	function ajaxPost(){
		var formData ={
				name : $("#name").val(),
				email : $("#email").val(),
				website : $("#website").val(),
				message : $("#message").val()
		}
		
		
		
		$.ajax({
		    type : "POST",
            contentType : "application/json",
            url : url + "/email",
            data : JSON.stringify(formData),
            dataType : 'json',
            success : function(result) {
                if(result.status == "Done"){
                
                	$("#msg").html("<strong>" + "Post Successfully!</strong>");
                }else{
                	
                	$("#msg").html("<strong>" + "Something Went wrong, send error email for team@ashnni.com!</strong>");
                }
                console.log(result);
            },
            error : function(e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });
         
        // Reset FormData after Posting
        resetData();
 
    }
     
    function resetData(){
        $("#name").val("");
        $("#email").val("");
        $("#website").val();
        $("#message").val();
    }
});