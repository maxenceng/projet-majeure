import Chart from 'chart.js'
import sass from '../sass/index.sass'

let path = window.location.pathname

if(path === '/refresh-auto.html') {
  const chart1 = document.querySelector('#myChart1')
  const chart2 = document.querySelector('#myChart2')
  const chart3 = document.querySelector('#myChart3')

  let labels = []
  let dataValues = []

  let data = {
      labels: labels,
      datasets: [
	  {
	      fill: false,
	      lineTension: 0,
	      backgroundColor: 'rgba(75,192,192,0.4)',
	      borderColor: 'rgba(75,192,192,1)',
	      data: dataValues,
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

  let i = 0
  //setInterval(test, 1000)  /* SCRIPT A DECOMMENTER EN DEHORS DE LA VM */


  function test() {
    labels.push(i)
    i++
    dataValues.push(Math.random()) // A remplacer par l'appel AJAX
    lineChart1.data.labels = labels
    lineChart1.data.datasets[0].data = dataValues
    lineChart1.update()
    lineChart2.data.labels = labels
    lineChart2.data.datasets[0].data = dataValues
    lineChart2.update()
    lineChart3.data.labels = labels
    lineChart3.data.datasets[0].data = dataValues
    lineChart3.update()
  }
}


if(path === '/refresh-button.html') {
  document.querySelector('#refreshBtn').addEventListener('click', () => {
  alert('REFRESH')
})
}


// A remplacer par les requetes AJAX
document.querySelector('#btnUp').addEventListener('click', () => {
  alert('UP')
})

document.querySelector('#btnLeft').addEventListener('click', () => {
  alert('LEFT')
})

document.querySelector('#btnRight').addEventListener('click', () => {
  alert('RIGHT')
})

document.querySelector('#btnDown').addEventListener('click', () => {
  alert('DOWN')
})