<template>
    <div id="company">
        <h1> Contacts()</h1>
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Slogan</th>

            </tr>
            </thead>
            <tbody>
            <tr v-for="contact in contacts">

                <th>{{ contact.name }}</th>
                <td>{{ contact.description}}</td>
                <td>{{ contact.slogan}}</td>

            <td>
                <button class="btn btn-danger" @click="deleteContact(contact)"> X</button>
            </td>
            </tr>
            </tbody>
        </table>
        <div>
        </div>
    </div>
</template>
<script>

    import {getContacts} from '../apiService/APIService';

    const API_URL = 'http://localhost:8080';
  //  const apiService = new APIService();

    export default {

        name: 'Company',

        components: {

        },


        data() {

            return {
                contacts: [],
                numberOfContacts:0,

            };

        },

        methods: {

            getContactsAll(){
                getContacts().then((data) => {
                    debugger;
                    this.contacts = data;
                    this.numberOfContacts= data.count;
                });
            },
        },

        mounted() {
            this.getContactsAll();
        },

        created() {
            this.getContactsAll();
        }
    }
    /*export default {
        name: "Company",
        props: {
            msg: String
        }
    }; */
</script>
<style>

</style>