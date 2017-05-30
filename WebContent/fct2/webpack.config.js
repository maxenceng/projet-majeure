const path = require('path')
const webpack = require('webpack')


module.exports = {
  entry: [
    './app/js/index.js',
  ],
  output: {
    path: path.join(__dirname, '/dist'),
    filename: 'bundle.js',
  },
  module: {
    rules: [
      { test: /\.js$/, loader: 'babel-loader', exclude: /node_modules/ },
      { test: /\.sass$/, loader: ['style-loader', 'css-loader', 'sass-loader'], exclude: /node_modules/ },
      { test: /\.(jpg|eot|svg|ttf|woff|woff2)$/, loader: ['url-loader'], exclude: /node_modules/ },
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
