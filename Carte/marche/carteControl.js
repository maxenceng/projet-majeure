var canvas=document.getElementById('carte');
var map=canvas.getContext('2d');

var mapArray=[
      [0,0,0,0,0,1,1,0,0,0,0,0,0,1,0],
      [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
      [0,1,0,0,0,0,0,1,0,0,0,0,1,0,0],
      [0,0,0,0,0,0,0,1,0,0,0,0,0,0,0],
      [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],
      [0,0,0,0,0,0,0,1,0,1,0,0,1,0,0],
      [0,1,0,0,0,0,0,0,1,1,0,0,0,0,0],
      [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
];

var grass = new Image();
var stone = new Image();
var robot = new Image();

grass.src='grass.png';
stone.src='stone.png';
robot.src='robot.png';

var posX=0;
var posY=0;

function drawMap(){
  for(var i=0; i< mapArray.length;i++){
      for(var j=0; j< mapArray[i].length;j++){
	if(mapArray[i][j]==0){
	    map.drawImage(grass,posX,posY,32,32);
	}
	if(mapArray[i][j]==1){
	    map.drawImage(stone,posX,posY,32,32);
	}
	posX+=32;
      }
      posX=0;
      posY+=32;
  }
}


var x=canvas.width/2;
var y=canvas.height/2;
var i;


function drawTraj(){
  map.beginPath();
  map.arc(x,y,2,0,Math.PI*2);
  map.fileStyle = "#0095DD";
  map.fill();
  map.closePath();
  i=Math.random();
  if(i<0.25){
   x += 4; //droit 
  }
  if(i<0.5 &&i>=0.25){
   x += -4; //left 
  }
  else{
   y += -4; //haute 
  }
}



drawMap();
setInterval(drawTraj,10);