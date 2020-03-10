import React, { Component } from 'react'
import '../css/App.css';

export default class Login extends Component {

  constructor(props) {
    super(props)

    this.state={
      name: '',
      city: ''
    }
  }

  updateState=(event) =>{
    if (this.state[event.target.name] !== undefined) {
      this.setState( {[event.target.name]: event.target.value})
    }

  }


  render() {
    return (
    <div>
    <div className="header"> Login </div>

        
       <div className="login-body">
          Name: 
          <input
            type="text" name="name" 
            value={this.state.name} onChange={this.updateState} /><br /><br />
          City: <input 
            type="text" name="city" 
            value={this.state.city} onChange={this.updateState} /><br /><br />

          <button className="add" onClick={()=>this.props.handleLogin(this.state.name,this.state.city)}>Login</button>
        
      </div>
      </div>
    )  
  }

}


