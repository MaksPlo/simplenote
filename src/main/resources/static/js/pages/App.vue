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
    import {addHandler} from "../util/ws"
    import {getIndex} from "../util/collections"

    export default {
        components: {
            NotesList
        },
        data() {
            return {
                notes: frontendData.notes,
                profile: frontendData.profile
            }
        },
        created() {
            addHandler(data => {
                let index = getIndex(this.notes, data.id)
                if (index > -1) {
                    this.notes.splice(index, 1, data)
                } else {
                    this.notes.push(data)
                }
            })
        }
    }
</script>

<style>

</style>