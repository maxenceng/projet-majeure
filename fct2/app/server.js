const express = require('express')
const path = require('path')

const app = express()

app.get('/', function(req, res) {
  return res.sendFile(path.join(__dirname, '/html/index.html'))
})

app.get('/js/index.js', function(req, res) {
  return res.sendFile(path.join(__dirname, '/js/index.js'))
})

app.listen(8000)
