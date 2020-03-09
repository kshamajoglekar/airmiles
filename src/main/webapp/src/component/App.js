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
      messages: [],
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
      .then((result) =>  {return this.setState({ messages: result })}
      )

    // this.state.messages.map((message) => {
    //   console.log("result=" + message)
    // })
    this.setState({ view: 'Wall' })
  }

  postMessage = (newMessage) => {

    fetch(`http://localhost:8080/user/${this.state.user}/message/add`,{
      method: 'post',
      body: newMessage
    })
      .then(result => result.json())
      .then((result) =>  {return this.setState({ messages: result })}
      )

    // this.state.messages.map((message) => {
    //   console.log("result=" + message)
    // })
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