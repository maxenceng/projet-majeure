import Chart from 'chart.js'
import axios from 'axios'
import sass from '../sass/index.sass'

let path = window.location.pathname


  const chart1 = document.querySelector('#myChart1')
  const chart2 = document.querySelector('#myChart2')
  const chart3 = document.querySelector('#myChart3')

  let labels = []
  let nbreCommande = []
  let distanceParcourue = []
  let nbreObstRencontres = []
  let nbreObstVisible = []

  let data = {
      labels: labels,
      datasets: [
	  {
	      fill: false,
	      lineTension: 0,
	      backgroundColor: 'rgba(75,192,192,0.4)',
  borderColor: 'rgba(75,192,192,1)',
	      data: [],
	  }
      ]
  }
  let options = {
    responsive: false,
    maintainAspectRatio: false,
    legend: {
      display: false,
    }
  }

  let content = {
    type: 'line',
    data: data,
    options: options
  }

  let lineChart1 = new Chart(chart1, content)
  let lineChart2 = new Chart(chart2, content)
  let lineChart3 = new Chart(chart3, content)

  let j = 0
  setInterval(test, 1000)  


  function test() {
    labels.push(j)
    j++
    axios.get('rest/cmd/measures').then(response => {
    	nbreCommande.push(response.data.nbreCommande)
    	distanceParcourue.push(response.data.distanceParcourue)
    	nbreObstRencontres.push(response.data.nbreObstRencontres)
    	nbreObstVisible.push(response.data.nbreObstVisible)
	    lineChart1.data.labels = labels
	    lineChart1.data.datasets[0].data = nbreCommande
	    lineChart1.update()
	    lineChart2.data.labels = labels
	    lineChart2.data.datasets[0].data = distanceParcourue
	    lineChart2.update()
	    lineChart3.data.labels = labels
	    lineChart3.data.datasets[0].data = nbreObstVisible
	    lineChart3.update()
    })
  }

// PARTIE CARTE

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


grass.src='grass.png';
stone.src='stone.png';
robot.src='robot.png';

var posX=0;
var posY=0;
var deltaX=0;
var deltaY=0;
var tabTraj=[];
var keys = {};

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
};

function drawTraj(){
	  for(var i=1;i<tabTraj.length;i++){
	    traj.beginPath();
	    traj.moveTo(tabTraj[i-1][0]+16,tabTraj[i-1][1]+16,5,5);
	    traj.lineTo(tabTraj[i][0]+16,tabTraj[i][1]+16,5,5);
	    traj.stroke();
	    //traj.fillRect(tabTraj[i][0]+16,tabTraj[i][1]+16,10,10);
	  }
}
	
drawMap()

// A remplacer par les requetes AJAX
document.querySelector('#btnUp').addEventListener('click', () => {
  axios.post('rest/cmd/UP', {}).then(response => {
	  console.log(response.data)
	  if(response.data === 'OK') {
		  deltaY -= 32;
		  if(deltaY<0){
		    deltaY=0;
		  }
		  tabTraj.push([deltaX,deltaY]);
		  drawRobTraj();
	  }
  })
})

document.querySelector('#btnLeft').addEventListener('click', () => {
	  axios.post('rest/cmd/LEFT', {}).then(response => {
		  console.log(response)
		  if(response.data === 'OK') {
			  deltaX -= 32;
			  if(deltaX<0){
				  deltaX=0;
			  }
			  tabTraj.push([deltaX,deltaY]);
			  drawRobTraj();
		  }
	  })
})

document.querySelector('#btnRight').addEventListener('click', () => {
	  axios.post('rest/cmd/RIGHT', {}).then(response => {
		  console.log(response)
		  	  if(response.data === 'OK') {
				  deltaX += 32;
				  if(deltaX>canvas.width-32){
				    deltaX=canvas.width-32;
				  }
		  tabTraj.push([deltaX,deltaY]);
		  drawRobTraj();
	  }
	  })
})

document.querySelector('#btnDown').addEventListener('click', () => {
	  axios.post('rest/cmd/DOWN', {}).then(response => {
		  console.log(response)
		  	  if(response.data === 'OK') {
		  deltaY += 32;
		  if(deltaY>canvas.height-32){
			    deltaY=canvas.height-32;
			  }
		  tabTraj.push([deltaX,deltaY]);
		  drawRobTraj();
	  }
	  })
})


// RECUP DONNEES CARTE
axios.get('rest/cmd/env').then(response => {
	console.log(response)
})