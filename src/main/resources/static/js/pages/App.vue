<template>
    <div>
        <div v-if="!profile">Необходимо авторизоваться через
            <a href="/login">Google</a>
        </div>
        <div v-else>
            <div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>
            <notes-list :notes="notes" />
        </div>
    </div>
</template>

<script>
    import NotesList from '../components/notes/NoteList.vue'

    export default {
        components:{
            NotesList
        },
        data() {
            return {
                notes: frontendData.notes,
                profile: frontendData.profile
            }
        }
    }
</script>

<style scoped>

</style>