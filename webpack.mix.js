let mix = require('laravel-mix');

let webpackConfig = {
    output: { publicPath: '/dist/' }
};

mix.js('src/main/javascript/index.js', 'src/main/resources/static/dist/')
    .vue()
    .setPublicPath('src/main/resources/static/dist/')
    .webpackConfig(webpackConfig)
    .extract();
