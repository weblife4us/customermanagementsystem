import React, {Component} from 'react';
import CustomerDataService from "../../../service/CustomerDataService";

const customerDataService = new CustomerDataService();

class PersonPage extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            customer: {},
            //pick up a URL path variable
            idSearchCriteria: props.match.params.id
        };
        this.getCustomerByName = this.getCustomerByName.bind(this);
    }

    // Using useEffect to retrieve data from an API (similar to componentDidMount in a class)
    componentDidMount() {
        this.getCustomerByName(this.state.idSearchCriteria);
    }

    getCustomerByName() {
        this.setState({isLoading: true});

        customerDataService.getByName(this.state.idSearchCriteria)
            .then(customer => {
                    this.setState({
                        customer: customer ? customer : "",
                        isLoading: false

                    });
                }
            )
            .catch(err => {
                console.log(err);
                this.setState({
                    customer: "",
                    isLoading: false
                })
            })
    }

    render() {
        return this.state.isLoading ? (
            <div>Loading...</div>
        ) : (
            <div>Person with ID: {this.state.customer.name}</div>
        )
    }

}

export default PersonPage;