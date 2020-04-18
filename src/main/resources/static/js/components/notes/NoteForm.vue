<template>
    <v-layout row>
        <v-text-field
                label="New title"
                placeholder="Write title"
                v-model="title"
        />
        <v-text-field
                label="New text"
                placeholder="Write text"
                v-model="text"
        />
        <v-btn @click="save">
            Save
        </v-btn>
    </v-layout>
</template>

<script>
    function getIndex(list, id) {
        for (var i = 0; i < list.length; i++) {
            if (list[i].id === id) {
                return i;
            }
        }
        return -1
    }

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
                const note = {text: this.text, title: this.title};

                if (this.id) {
                    this.$resource('/notes{/id}').update({
                        id: this.id,
                        text: this.text,
                        title: this.title
                    }, note).then(result => result.json().then(data => {
                        const index = getIndex(this.notes, data.id);
                        this.notes.splice(index, 1, data)
                        this.text = ''
                        this.id = ''
                    }))
                } else {
                    this.$resource('/notes{/id}').save(note).then(result => result.json().then(data => {
                            this.notes.push(data)
                            this.text = ''
                            this.title = ''
                        })
                    )
                }
            }
        }
    }
</script>

<style>

</style>