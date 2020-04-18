<template>
    <div style="position: relative; width: 600px;">
                <note-form :notes="notes" :noteAttr="note"/>
        <note-row v-for="note in notes"
                  :key="note.id"
                  :note="note"
                  :editNote="editNote"
                  :deleteNote="deleteNote"
                  :notes="notes"/>
    </div>
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
                note: null
            }
        },
        methods: {
            editNote(note) {
                this.note = note
            },
            deleteNote(note) {
                this.$resource('/notes{/id}').remove({id: note.id}).then(result => {
                    if (result.status === 204) {
                        this.notes.splice(this.notes.indexOf(this.note), 1)
                    }
                })
            }
        }
    }
</script>

<style>

</style>