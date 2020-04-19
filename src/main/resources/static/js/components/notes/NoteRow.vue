<template>
    <v-card class="my-2">
        <v-card-title class="title font-italic font-weight-bold grey lighten-2">
            {{ note.title }}
        </v-card-title>
        <v-card-text class="blue-grey lighten-3">
            {{ note.text }}
        </v-card-text>

        <v-card-actions class="display: flex justify-content: space-around">
            <v-btn type="button" value="Edit" @click="edit" small flat round>Edit</v-btn>
            <v-btn icon @click="del" small>
                <v-icon>delete</v-icon>
            </v-btn>
            <div class="display: flex justify-content: space-around">
            <span style="margin-left: 80%"> {{note.time | formatDate}}</span>
            </div>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        props: ['note', 'editNote', 'deleteNote', 'notes'],
        methods: {
            edit() {
                this.editNote(this.note)
            },
            del() {
                this.deleteNote(this.note)

            }
        }
    }
</script>

<style scoped>
</style>