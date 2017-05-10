const path = require('path')
const webpack = require('webpack')

module.exports = {
  entry: [
    './app/js/index.js',
  ],
  output: {
    path: path.join(__dirname, '/dist'),
    publicPath: 'http://localhost:8080/dist', // Utile lors du developement
    filename: 'bundle.js',
  },
  module: {
    rules: [
      { test: /\.js$/, loader: 'babel-loader', exclude: /node_modules/ },
    ],
  },
  devServer: {
    hot: true,
  },
  /**
   * Plugins pour permettre d'utiliser le HMR (Hot Module Replacement)
   */
  plugins: [
    new webpack.optimize.OccurrenceOrderPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NamedModulesPlugin(),
    new webpack.NoEmitOnErrorsPlugin(),
  ],
}
