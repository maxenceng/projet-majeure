var canvas=document.getElementById('carte');
var context=canvas.getContext('2d');

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

grass.src='grass.jpg';
stone.src='stone.jpg';

var posX=0;
var posY=0;

for(var i=0; i< mapArray.length;i++){
    for(var j=0; j< mapArray[i].length;j++){
      if(mapArray[i][j]==0){
	  context.drawImage(grass,posX,posY,32,32);
      }
       if(mapArray[i][j]==1){
	  context.drawImage(stone,posX,posY,32,32);
      }
      posX+=32;
    }
    posX=0;
    posY+=32;
}