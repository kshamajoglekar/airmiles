import React from 'react'
import { shallow } from 'enzyme';
import sinon from 'sinon';

import AddPerson from '../AddPerson'

describe('Add Person test suite', () => {

  it('Has state for hold info for the form', () => {
    const wrapper = shallow(<AddPerson/>)
    const state = wrapper.state()

    expect(state.firstName).toBe('')
    expect(state.lastName).toBe('')

  })

  it('Has input fields', () => {
    const wrapper = shallow(<AddPerson/>)
    const state = wrapper.state()

    expect(wrapper.find('input[type="text"][name="firstName"][value=""]')).toHaveLength(1)
    expect(wrapper.find('input[type="text"][name="lastName"][value=""]')).toHaveLength(1)

  })

  it('State changes on input event', () => {
    const wrapper = shallow(<AddPerson/>)
    const changeFirstName = {target:  {name: 'firstName', value: 'Kurt' }}
    const changeLastName = {target:  {name: 'lastName', value: 'Goedel' }}

    wrapper.find('input[type="text"][name="firstName"][value=""]').simulate('change', changeFirstName)
    wrapper.find('input[type="text"][name="lastName"][value=""]').simulate('change', changeLastName)
    
    const state = wrapper.state()

    expect(state.firstName).toBe('Kurt')
    expect(state.lastName).toBe('Goedel')

  })



  it('has create person and cancel button' , () =>{

    const wrapper = shallow(<AddPerson />)

    const addButton =wrapper.find('button.add')
    expect(addButton).toHaveLength(1)
    expect(addButton.text()).toBe('Add Person')

    const cancelButton = wrapper.find('button.cancel')
    expect(cancelButton).toHaveLength(1)
    expect(cancelButton.text()).toBe('Go Back')

  })

  it('submits new name and cleans out state', () => {
    const spy = sinon.spy()
    const wrapper = shallow(<AddPerson addPerson={spy}/>)
    wrapper.setState({ firstName: 'Kurt', lastName: 'Goedel'})
  
    wrapper.find('button.add').first().simulate('click')
    expect(spy.calledOnceWith('Kurt','Goedel')).toBe(true)
    
    //expect(state.firstName).toBe('')
    //expect(state.lastName).toBe('')

  })

})