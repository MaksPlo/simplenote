<template>
    <div>
        <input type="text" placeholder="Write title" v-model="title"/>
        <input type="text" placeholder="Write text" v-model="text"/>
        <input type="button" value="Save" @click="save"/>
    </div>
</template>

<script>
    import {sendNote} from "../../util/ws"

    export default {
        props: ['notes', 'noteAttr'],
        data() {
            return {
                title: '',
                text: '',
                id: ''
            }
        },
        watch: {
            noteAttr: function (newVal, oldVal) {
                this.text = newVal.text
                this.id = newVal.id
            }
        },
        methods: {
            save() {
                sendNote({id: this.id, text: this.text, title: this.title})
                this.text = ''
                this.title = ''
                this.id = ''
            }
        }
    }
</script>

<style>

</style>


