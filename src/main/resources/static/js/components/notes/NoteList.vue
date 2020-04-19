<template>
    <v-layout align-space-around justify-start column>
        <note-form :notes="notes" :noteAttr="note"/>
        <v-layout row>
            <v-text-field label="Find note" placeholder="Write note title" v-model="title"/>
        </v-layout>
        <note-row v-for="note in filteredNotes"
                  :key="note.id"
                  :note="note"
                  :editNote="editNote"
                  :deleteNote="deleteNote"
                  :notes="notes"/>
    </v-layout>
</template>

<script>
    import NoteRow from 'components/notes/NoteRow.vue'
    import NoteForm from 'components/notes/NoteForm.vue'

    export default {
        props: ['notes'],
        components: {
            NoteRow,
            NoteForm
        },
        data() {
            return {
                title: '',
                note: null
            }
        },
        computed: {
            filteredNotes() {
                return this.notes.filter(note => {
                    return note.title.toLowerCase().indexOf(this.title.toLowerCase()) !== -1
                })
            }

        },
        methods: {
            editNote(note) {
                this.note = note
            },
            deleteNote(note) {
                this.$resource('/notes{/id}').remove({id: note.id}).then(result => {
                    if (result.status === 204) {
                        this.notes.splice(this.notes.indexOf(note), 1)
                    }
                })
            }
        }
    }
</script>

<style>

</style>