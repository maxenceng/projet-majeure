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
const size = 64

const mapData = []

// RECUP DONNEES CARTE

export const drawMap = () => {
  for (let i = 0; i < mapData.length; i += 1) {
    for (let j = 0; j < mapData[i].length; j += 1) {
      if (mapData[i][j] === 'FREE') {
        map.drawImage(grass, posX, posY, size, size)
      }
      if (mapData[i][j] === 'OBSTACLE') {
        map.drawImage(stone, posX, posY, size, size)
      }
      if (mapData[i][j] === 'ROBOT') {
        map.drawImage(grass, posX, posY, size, size)
        posRobotX = posX
        posRobotY = posY
        rob.drawImage(robot, posRobotX, posRobotY, size, size)
        tabTraj.push([posRobotX, posRobotY])
      }
      posX += size
    }
    posX = 0
    posY += size
  }
  posY = 0
}


export const drawEnv = () => {
  axios.get('rest/cmd/env').then((response) => {
    const data = response.data.donnees
    for (let i = 0; i < 8; i += 1) {
      mapData.push(data.splice(0, 12))
    }
    for (let i = 0; i < mapData.length; i += 1) {
      for (let j = 0; j < mapData[i].length; j += 1) {
        mapData[i][j] = mapData[i][j].etat
      }
    }
    drawMap()
  })
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
  rob.drawImage(robot, posRobotX + deltaX, posRobotY + deltaY, size, size)
  drawTraj()
}

export const move = (direction) => {
  switch (direction) {
    case 'UP':
      deltaY -= size
      if (posRobotY + deltaY < 0) {
        deltaY = 0
      }
      tabTraj.push([posRobotX + deltaX, posRobotY + deltaY])
      drawRobTraj()
      break
    case 'DOWN':
      deltaY += size
      if (posRobotY + deltaY > canvas.height - size) {
        deltaY = canvas.height - size
      }
      tabTraj.push([posRobotX + deltaX, posRobotY + deltaY])
      drawRobTraj()
      break
    case 'LEFT':
      deltaX -= size
      if (posRobotX + deltaX < 0) {
        deltaX = 0
      }
      tabTraj.push([posRobotX + deltaX, posRobotY + deltaY])
      drawRobTraj()
      break
    case 'RIGHT':
      deltaX += size
      if (posRobotX + deltaX > canvas.width - size) {
        deltaX = canvas.width - size
      }
      tabTraj.push([posRobotX + deltaX, posRobotY + deltaY])
      drawRobTraj()
      break
    default:
      break
  }
}
