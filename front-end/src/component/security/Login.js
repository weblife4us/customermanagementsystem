import React, {Component} from 'react';

class Login extends Component {

    render() {
        return (
            <div>
                <p>
                    <label for="login">Enter your Login</label>
                    <input type="text" id="login"/>
                </p>
                <p>
                    <div>
                        <label htmlFor="password">Enter your password</label>
                        <input type="password" id="password"/>
                    </div>
                </p>
            </div>
        )
    }
}

export default Login;