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
}



var robot_obj = {
	speed: 256, // movement in pixels per second
	x: 0,
	y: 0
};

robot_obj.x =canvas.width/2;
robot_obj.y =canvas.height/2-32;

var keysDown = {};

addEventListener("keydown", function (e) {
	keysDown[e.keyCode] = true;
}, false);

addEventListener("keyup", function (e) {
	delete keysDown[e.keyCode];
}, false);

var update = function (modifier) {
 	
	if (38 in keysDown) { // Player holding up
		robot_obj.y -= robot_obj.speed * modifier;
	}
	if (40 in keysDown) { // Player holding down
		robot_obj.y += robot_obj.speed * modifier;
	}
	if (37 in keysDown) { // Player holding left
		robot_obj.x -= robot_obj.speed * modifier;
	}
	if (39 in keysDown) { // Player holding right
		robot_obj.x += robot_obj.speed * modifier;
	}


};

var render = function () {
    map.clearRect(0, 0, canvas.width, canvas.height);
    drawMap();
    map.drawImage(robot,robot_obj.x,robot_obj.y,32,32);
};

// The main game loop
var main = function () {

	var now = Date.now();
	var delta = now - then;

	update(delta / 1000);
	render();

	then = now;
	
	// Request to do this again ASAP
	requestAnimationFrame(main);
};

// Cross-browser support for requestAnimationFrame
var w = window;
requestAnimationFrame = w.requestAnimationFrame || w.webkitRequestAnimationFrame || w.msRequestAnimationFrame || w.mozRequestAnimationFrame;

var then = Date.now();
	
main();