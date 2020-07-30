Feature: Profile Update Tests
  I as a user
  Need update my personal data
  To receive offers and discounts on services provided


  Background:
    Given user has been on the main page
    And he has logged in
      | filter  |
      | 8487222 |
    And he has navigate to profile update page

  @tag1
  Scenario: Profile update Successfully
    When he modifies his personal data in fields: Nombres, Direccion, Telefono and Celular
    Then he should see the message: La información ingresada fue almacenada con éxito.


  Scenario Outline: Profile update failed due to a mandatory empty field
    When he tries to save changes leaving the mandatory field <field> empty
    Then he should see the next message: Los campos marcados con * son requeridos.
    Examples:
      | field     |
      | Nombres   |
      | Direccion |
      | Celular   |
      | Telefono  |


  Scenario Outline: Check lenght fields
    When he updates the field <field> with a value of <quantity> characters
    Then he should see the field <field> with <expectedquantity> characters
    Examples:
      | field         | quantity | expectedquantity |
      | Nombres       | 101      | 100              |
      | Apellidos     | 101      | 100              |
      | Direccion     | 201      | 200              |
      | Telefono      | 51       | 50               |
      | Celular       | 16       | 15               |
      | CorreoAlterno | 101      | 100              |


