<template>
    <div>
        <h1>{{ product.name }}</h1>
        <p>{{ product.description }}</p>

        <inertia-link href="/">Back</inertia-link>
    </div>
</template>

<script>
export default {
    props: {
        product: Object,
    }
}
</script>
