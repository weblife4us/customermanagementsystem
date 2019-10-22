import React, {Component} from 'react';
import CustomerDataService from "../../../service/CustomerDataService";

const customerDataService = new CustomerDataService();

class AllPersonsPage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            customers: [],
            loading: true
        }
    }

    componentDidMount() {
        customerDataService.getAll().then(result => {
            console.log(result);
            this.state.customers = result;
        })
    }

    render() {
        return (
            <div>All customers of the system</div>
        )
    }
}

export default AllPersonsPage;