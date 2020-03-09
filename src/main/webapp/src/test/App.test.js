import React from 'react'
import { shallow } from 'enzyme';
import sinon from 'sinon';

import App from '../component/App'
import Home from '../Home'

describe("Application Test Suite", () => { 

  it("Application Exist",()=>{
    const wrapper = shallow(<App />)
    expect(wrapper.exists("render"))
  })

  it("Shallow test for Add Person button", ()=> {
    const wrapper = shallow(<App />)
    const addButton = wrapper.find(Home)

    expect(addButton).toHaveLength(1)

  })

  it("Test for Add Person button clicked", ()=> {
    const wrapper = shallow(<App />)
    wrapper.instance().addPerson()

    const addButton = wrapper.find(Home)
    expect(addButton).toHaveLength(1)


  })

})