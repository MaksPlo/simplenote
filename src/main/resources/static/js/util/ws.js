import SockJS from 'sockjs-client'
import { Stomp } from '@stomp/stompjs'


var stompClient = null
const handlers = []


export function connect() {
    const socket = new SockJS('/gs-guide-websocket')
    console.log(socket)
    stompClient = Stomp.over(socket)
    stompClient.connect({}, frame => {
        console.log('Connected: ' + frame)
        stompClient.subscribe('/topic/activity', note => {
            handlers.forEach(handler => handler(JSON.parse(note.body)))
        })
    })
}

export function addHandler(handler) {
    handlers.push(handler)
}

export function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect()
    }
    console.log("Disconnected")
}

export function sendNote(note) {
    stompClient.send("/app/changeNote", {}, JSON.stringify(note))
}
