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

  let i = 0
  setInterval(test, 1000)  /* SCRIPT A DECOMMENTER EN DEHORS DE LA VM */


  function test() {
    labels.push(i)
    i++
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



if(path === '/refresh-button.html') {
  document.querySelector('#refreshBtn').addEventListener('click', () => {
  alert('REFRESH')
})
}

// A remplacer par les requetes AJAX
document.querySelector('#btnUp').addEventListener('click', () => {
  axios.post('rest/cmd/UP', {}).then(response => {
	  console.log(response)
  })
})

document.querySelector('#btnLeft').addEventListener('click', () => {
	  axios.post('rest/cmd/LEFT', {}).then(response => {
		  console.log(response)
	  })
})

document.querySelector('#btnRight').addEventListener('click', () => {
	  axios.post('rest/cmd/RIGHT', {}).then(response => {
		  console.log(response)
	  })
})

document.querySelector('#btnDown').addEventListener('click', () => {
	  axios.post('rest/cmd/DOWN', {}).then(response => {
		  console.log(response)
	  })
})