import React, {Component} from 'react';
import TextField from "@material-ui/core/TextField";


class InputField extends Component {
    state: {
        fieldValue: "",
    };

    render() {
        return (
            <TextField
                value=""
                placeholder="Login"
                onChange={e => {
                    this.setState({userName: e.target.value});
                }}
            />
        )
    }
}