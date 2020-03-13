import React from 'react'
import { shallow } from 'enzyme';

import App from '../component/App'


describe("Application Test Suite", () => { 

  it("Application Exist",()=>{
    const wrapper = shallow(<App />)
    expect(wrapper.exists("render"))
  })

  it("Test if Login component exist", ()=> {
    const wrapper = shallow(<App />)
    const state=wrapper.state()

    expect(state.view).toBe('Login')

  })

})