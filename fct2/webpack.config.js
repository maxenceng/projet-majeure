const path = require('path')
const webpack = require('webpack')
const htmlWebpackPlugin = require('html-webpack-plugin')

const htmlWebpackPluginConfig = new htmlWebpackPlugin({
  template: './app/html/index.html',
  filename: 'index.html',
  inject: 'body'
})


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
    htmlWebpackPluginConfig,
    new webpack.optimize.OccurrenceOrderPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NamedModulesPlugin(),
    new webpack.NoEmitOnErrorsPlugin(),
  ],
}
