import axios from 'axios';

//Service to get data about customers from BE
class CustomerDataService {

    async test() {
        return await axios.get("/api/customers/test")
            .then(result => {
                    console.log(result);
                }
            )
    }

    async getByName(id) {
        return await axios.get("/api/customers/" + id)
            .then(res => {
                console.log(res);
                return res.data;
            })
            .catch(err => {
                console.log(err);
                return [{"message": "No customer found"}];
            });

    }

    async getAll() {
        return await axios.get(`/api/customers`)
            .then(res => res.data.customers)
            .catch(err => {
                console.log(err);
                return [{id: 'n/a'}];
            });
    }

}

export default CustomerDataService;