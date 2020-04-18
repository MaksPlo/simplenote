<template>
    <div>
        <i>({{ note.id }})</i> {{ note.title }} {{ note.text }}
        <span style="position: absolute; right: 0">
        <input type="button" value="Edit" @click="edit"/>
        <input type="button" value="X" @click="del"/>
        </span>
    </div>
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