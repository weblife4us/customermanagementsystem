import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
    state = {};

    componentDidMount() {
        this.testCall();
    };

    testCall = () => {
        fetch('/api/customers/test')
            .then(response => response.text())
            .then(message => {
                this.setState({message: message});
            });
    };


    render() {
        return (

            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <p>
                        Edit <code>src/App.js</code> and save to reload.
                    </p>
                    {this.state.message} - this is the message from the state
                </header>
            </div>
        )
    };
}


export default App;
