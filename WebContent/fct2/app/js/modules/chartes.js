import Chart from 'chart.js'
import axios from 'axios'


const chart1 = document.querySelector('#myChart1')
const chart2 = document.querySelector('#myChart2')
const chart3 = document.querySelector('#myChart3')
const chart4 = document.querySelector('#myChart4')

const labels = []
const nbreCommande = []
const distanceParcourue = []
const nbreObstRencontres = []
const nbreObstVisible = []

const data = {
  labels,
  datasets: [
    {
      fill: false,
      lineTension: 0,
      backgroundColor: 'rgba(75,192,192,0.4)',
      borderColor: 'rgba(75,192,192,1)',
      data: [],
    },
  ],
}
const options = {
  responsive: false,
  maintainAspectRatio: false,
  legend: {
    display: false,
  },
}

const content = {
  type: 'line',
  data,
  options,
}

const lineChart1 = new Chart(chart1, content)
const lineChart2 = new Chart(chart2, content)
const lineChart3 = new Chart(chart3, content)
const lineChart4 = new Chart(chart4, content)

let k = 0


export default () => {
  labels.push(k)
  k += 1
  axios.get('rest/cmd/measures').then((response) => {
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
    lineChart3.data.datasets[0].data = nbreObstRencontres
    lineChart3.update()
    lineChart4.data.labels = labels
    lineChart4.data.datasets[0].data = nbreObstVisible
    lineChart4.update()
  })
}
