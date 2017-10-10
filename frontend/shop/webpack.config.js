const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');

const HtmlWebpackConfigIndex = new HtmlWebpackPlugin({
  template: './src/index.html',
  filename: 'index.html',
  inject: 'body'
});

const distDir = path.resolve(__dirname, './dist');
const srcDir = path.resolve(__dirname, './src');

const pathRewriteVal = {'^/api': ''};

module.exports = {
  entry: srcDir + '/index.js',
  output: {
    path: distDir,
    filename: 'app_bundle.js'
  },
  module: {
    loaders: [
      { test: /\.js$/, loader: 'babel-loader', exclude: /node_modules/ },
      { test: /\.jsx$/, loader: 'babel-loader', exclude: /node_modules/ },
      { test: /\.sass$/, loaders: ['raw', 'sass'] },
      { test: /\.(woff2?|ttf|eot|svg)(\?v=\d+\.\d+\.\d+)?$/, loader: "file?name=fonts/[name].[ext]" },
      { test: /bootstrap\/dist\/js\/umd\//, loader: 'imports?jQuery=jquery' }
      //TODO: add fontawesome icons
    ],
  },
  plugins: [
      HtmlWebpackConfigIndex,
      new webpack.ProvidePlugin({   
          jQuery: 'jquery',
          $: 'jquery',
          jquery: 'jquery'
      }),
      new webpack.EnvironmentPlugin({
          NODE_ENV: 'development'
      })
  ],
  devServer: {
    contentBase: path.join(__dirname, "dist"),
    compress: true,
    port: 8080,
    proxy: {
      '/api/order-process': {
        target: 'http://localhost:8084',
        secure: false,
        pathRewrite: pathRewriteVal
      },
      '/api/cart': {
        target: 'http://localhost:8085',
        secure: false,
        pathRewrite: pathRewriteVal
      },
      '/api/product': {
        target: 'http://localhost:8085',
        secure: false,
        pathRewrite: pathRewriteVal
      },
      /*Redirect for order-process client not possible as /order/index.html points to /app.bundle.js which is the shop bundle for some reason...*/
      '/order/**': {
        target: 'http://localhost:8180/',
        secure: false,
        pathRewrite: {'^/order': ''}
      }
    }
  }
}
