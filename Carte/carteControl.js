var canvas=document.getElementById('carte');
var map=canvas.getContext('2d');

var canvas1=document.getElementById('traj');
var traj=canvas1.getContext('2d');

var canvas2=document.getElementById('robot');
var rob=canvas2.getContext('2d');

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
var sand = new Image();

grass.src='grass.png';
stone.src='stone.png';
sand.src='stone.jpg';
robot.src='robot.png';

var posX=0;
var posY=0;
var deltaX=0;
var deltaY=0;
var tabTraj=[];
var keys = {};
var i=0;




addEventListener("keydown", keysPressed,false);

addEventListener("keyup", keysReleased, false);

function keysPressed(e){
	  keys[e.keyCode] = true;
	  if (keys[38]) { 
	    // Player holding up
		  deltaY -= 32;
		  if(deltaY<0){
		    deltaY=0;
		  }
	  }
	  else if (keys[40]) { 
	    // Player holding down
		  deltaY += 32;
		  if(deltaY>canvas.height-32){
		    deltaY=canvas.height-32;
		  }

	  }
	  else if (keys[37]) {
	    // Player holding left
		  deltaX -= 32;
		  if(deltaX<0){
		    deltaX=0;
		  }
	  }
	  else if (keys[39]) { // Player holding right
		  deltaX += 32;
		  if(deltaX>canvas.width-32){
		    deltaX=canvas.width-32;
		  }
	}
	
	tabTraj.push([deltaX,deltaY]);
	e.preventDefault();
	drawRobTraj();
}

function keysReleased(e) {
    // mark keys that were released
    keys[e.keyCode] = false;
} 

function drawTraj(){
  for(i=1;i<tabTraj.length;i++){
    traj.beginPath();
    traj.moveTo(tabTraj[i-1][0]+16,tabTraj[i-1][1]+16,5,5);
    traj.lineTo(tabTraj[i][0]+16,tabTraj[i][1]+16,5,5);
    traj.stroke();
    //traj.fillRect(tabTraj[i][0]+16,tabTraj[i][1]+16,10,10);
  }
}
var drawMap = function(){

  
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
    posY=0;
};

function drawRobTraj(){
    rob.clearRect(0, 0, canvas.width, canvas.height);
    rob.drawImage(robot,deltaX,deltaY,32,32);
    drawTraj();
}

drawMap();