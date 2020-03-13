import React, { Component } from 'react';

import '../css/App.css';
import Wall from './Wall'
import Login from './Login'
import callApi from '../fetch/base.js'

export default class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      user: '',
      city: '',
      messages: [{message: String,
        responses:[],
        createdDateTime: String
      }],
      user: {},
      view: 'Login'
    };
  }

  componentDidMount() {
  }



  goToWall = (name, city) => {
    //callApi("goToWall")
    this.setState({ user: name, city: city })

    fetch(`http://localhost:8080/user/${name}/messages`)
      .then(result => result.json())
      .then((result) =>  {
        if(result && result.length  > 0){      
        return this.setState({ messages: result })
        }else{
          return this.setState({ messages: [{message:"You have no new mesg"}]})
      }
    })
    this.setState({ view: 'Wall' })
  }

  postMessage = (newMessage) => {

    fetch(`http://localhost:8080/user/${this.state.user}/message/add`,{
      method: 'post',
      body: newMessage
    })
      .then(result => result.json())
      .then((result) =>  {
        if(result && result.length  > 0){
          return this.setState({ messages: result })     
          }else{
            return this.setState({ messages: [{message:"You have no new mesg"}]})
        }
      })
      this.setState({ view: 'Wall' })
    }
 

  getView = () => {
    switch (this.state.view) {
      case 'Login':
        return <Login handleLogin={this.goToWall} />
      case 'Wall':
        return <Wall messages={this.state.messages} handlePostMessage={this.postMessage} />
    }
  }

  render() {
    return (
      <div className="App">
        {this.getView()}
      </div>
    );
  }
}
