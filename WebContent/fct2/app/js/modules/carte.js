import axios from 'axios'

const canvas = document.getElementById('carte')
const map = canvas.getContext('2d')

const canvas1 = document.getElementById('traj')
const traj = canvas1.getContext('2d')

const canvas2 = document.getElementById('robot')
const rob = canvas2.getContext('2d')


const grass = new Image()
const stone = new Image()
const robot = new Image()


grass.src = 'grass.png'
stone.src = 'stone.png'
robot.src = 'robot.png'

let posX = 0
let posY = 0
let deltaX = 0
let deltaY = 0
const tabTraj = []
let posRobotX
let posRobotY

let mapData = []

// RECUP DONNEES CARTE
export const drawMapFinal = () => {
	  for (let i = 0; i < mapData.length; i += 1) {
	    for (let j = 0; j < mapData[i].length; j += 1) {
	      if (mapData[i][j] === "FREE") {
	        map.drawImage(grass, posX, posY, 32, 32)
	      }
	      if (mapData[i][j] === "OBSTACLE") {
	        map.drawImage(stone, posX, posY, 32, 32)
	      }
	      if (mapData[i][j] === "ROBOT") {
	        map.drawImage(grass, posX, posY, 32, 32)
	        posRobotX = posX
	        posRobotY = posY
	        rob.drawImage(robot, posRobotX, posRobotY, 32, 32)
	      }
	      posX += 32
	    }
	    posX = 0
	    posY += 32
	  }
	  posY = 0
}


export const test = () => {
	axios.get('rest/cmd/env').then((response) => {
		  let data = response.data.donnees
		  let length = data.length
		  for (let i = 0; i < Math.sqrt(length); i += 1) {
			  mapData.push(data.splice(0, 9))
		  }
		  for (let i = 0; i < mapData.length; i += 1) {
			  for (let j = 0; j < mapData[i].length; j += 1) {
				  mapData[i][j] = mapData[i][j].etat
			  }
		  }
		  drawMapFinal()
		})
}

const mapArray = [
  [0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
  [0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0],
  [0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0],
  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
]


export const drawMap = () => {
  for (let i = 0; i < mapArray.length; i += 1) {
    for (let j = 0; j < mapArray[i].length; j += 1) {
      if (mapArray[i][j] === 0) {
        map.drawImage(grass, posX, posY, 32, 32)
      }
      if (mapArray[i][j] === 1) {
        map.drawImage(stone, posX, posY, 32, 32)
      }
      if (mapArray[i][j] === 2) {
        map.drawImage(grass, posX, posY, 32, 32)
        posRobotX = posX
        posRobotY = posY
        rob.drawImage(robot, posRobotX, posRobotY, 32, 32)
      }
      posX += 32
    }
    posX = 0
    posY += 32
  }
  posY = 0
}



const drawTraj = () => {
  for (let i = 1; i < tabTraj.length; i += 1) {
    traj.beginPath()
    traj.moveTo(tabTraj[i - 1][0] + 16, tabTraj[i - 1][1] + 16, 5, 5)
    traj.lineTo(tabTraj[i][0] + 16, tabTraj[i][1] + 16, 5, 5)
    traj.stroke()
  }
}

const drawRobTraj = () => {
  rob.clearRect(0, 0, canvas.width, canvas.height)
  rob.drawImage(robot, posRobotX + deltaX, posRobotY + deltaY, 32, 32)
  drawTraj()
}

export const move = (direction) => {
  switch (direction) {
    case 'UP':
      deltaY -= 32
      if (deltaY < 0) {
        deltaY = 0
      }
      tabTraj.push([posRobotX + deltaX, posRobotY + deltaY])
      drawRobTraj()
      break
    case 'DOWN':
      deltaY += 32
      if (deltaY > canvas.height - 32) {
        deltaY = canvas.height - 32
      }
      tabTraj.push([posRobotX + deltaX, posRobotY + deltaY])
      drawRobTraj()
      break
    case 'LEFT':
      deltaX -= 32
      if (deltaX < 0) {
        deltaX = 0
      }
      tabTraj.push([posRobotX + deltaX, posRobotY + deltaY])
      drawRobTraj()
      break
    case 'RIGHT':
      deltaX += 32
      if (deltaX > canvas.width - 32) {
        deltaX = canvas.width - 32
      }
      tabTraj.push([posRobotX + deltaX, posRobotY + deltaY])
      drawRobTraj()
      break
    default:
      break
  }
}
