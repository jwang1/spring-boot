const { injectBablePlugin } = require('react-app-rewired');
// overrides Ant Design's default less variables to customize theme
const rewireLess = require('react-app-rewire-less');

module.exports = function override(config, env) {
    config = injectBablePlugin(['import', {libraryName: 'antd', style: true}], config);
    config = rewireLess.withLoaderOptions({
        modifyVars: {
            '@layout-body-background': '#FFFFFF',
            '@layout-header-background': '#FFFFFF',
            '@layout-footer-background': '#FFFFFF'
        },

        javascriptEnabled: true
    }) (config, env);

    return config;
}

