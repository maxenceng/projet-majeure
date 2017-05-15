$(document).ready(function(){
  $("#myButton").click(function(){
	  
	  //On récupère l'état envoyé par l'admin et on test :
	  //If a rajouter ici.
	  
	  	$.post("rest/cmd/UP",
    		  {},
    		  function(data,status){
    		    alert("Post Done received data: " + data + "\nStatus: " + status);
    	});    
  });

  $("#myButton3").click(function(){
	  	$.post("rest/cmd/DOWN",
  		  {},
  		  function(data,status){
  		    alert("Post Done received data: " + data + "\nStatus: " + status);    
  	});   
});

  $("#myButton4").click(function(){
	  	$.post("rest/cmd/RIGHT",
  		  {},
  		  function(data,status){
  		    alert("Post Done received data: " + data + "\nStatus: " + status);
  	});    
});

  $("#myButton5").click(function(){
	  	$.post("rest/cmd/LEFT",
  		  {},
  		  function(data,status){
  		    alert("Post Done received data: " + data + "\nStatus: " + status);
  	});    
});

  

  $("#myButton2").click(function(){
	  	$.get("rest/cmd/env",
  		  function(data,status){
	  		
	  		for(i in data.data){
	  			$("#myContent").append("<h6>---------------------------</h6>");
	  			$("#myContent").append("<h5> X:"+data.data[i].x+",Y:"+data.data[i].y+"</h5>");
	  			$("#myContent").append("<h5> Value:"+data.data[i].val+"</h5>");
	  			$("#myContent").append("<h6>---------------------------</h6>");
	  			$("#mylastContent").text(data.data[i].val);
	  			
	  		}
	  		
  		    alert("Get Done received data: " + data + "\nStatus: " + status);
  	});    
});
});