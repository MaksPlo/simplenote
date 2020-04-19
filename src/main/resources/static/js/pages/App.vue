<template>
    <v-app>
        <v-toolbar app>
            <v-toolbar-title>SimpleNote</v-toolbar-title>
            <v-spacer></v-spacer>
            <span v-if="profile">{{profile.name}}</span>
            <v-btn v-if="profile" icon href="/logout">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
        </v-toolbar>
        <v-content>
            <v-container v-if="!profile">
                Необходимо авторизоваться через
                <a href="/login">Google</a>
            </v-container>
            <v-container v-if="profile">
                <notes-list :notes="notes"/>
            </v-container>
        </v-content>
    </v-app>
</template>

<script>
    import NotesList from '../components/notes/NoteList.vue'

    export default {
        components: {
            NotesList,
        },
        data() {
            return {
                notes: frontendData.notes,
                profile: frontendData.profile
            }
        }
    }
</script>

<style>

</style>