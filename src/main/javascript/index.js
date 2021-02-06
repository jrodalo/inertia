import { createApp, h } from 'vue'
import { App, plugin } from '@inertiajs/inertia-vue3'

const el = document.getElementById('app')

createApp({
    render: () => h(App, {
        initialPage: JSON.parse(el.dataset.page),
        resolveComponent: name => import(`./pages/${name}`).then(module => module.default),
    })
}).use(plugin).mount(el)
