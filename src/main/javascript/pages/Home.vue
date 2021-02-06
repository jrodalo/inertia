<template>
    <div>
        <h1>Spring Boot + InertiaJS DEMO</h1>

        <ul v-for="product in products">
            <li><inertia-link :href="`/products/${product.id}`">{{ product.name }}</inertia-link></li>
        </ul>

    </div>
</template>

<script>
export default {
    props: {
        products: Array,
    }
}
</script>

<style scoped>
h1 {
    color: #043D5B;
}
</style>
