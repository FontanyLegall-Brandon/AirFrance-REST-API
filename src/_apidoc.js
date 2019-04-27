/**
 * *
 * @api {post} /register UserRegister
 * @apiVersion 0.1.0
 * @apiDescription Register User in the app
 * @apiName UserRegister
 * @apiGroup UserControler
 * @apiParam (Requested) {String} name The nickname
 * @apiParam (Requested) {String} email
 * @apiParam (Requested) {String} pwd Password
 * @apiParam (Requested) {String} birthday Birthday as dd/MM/yyyy
 * @apiParam (Requested) {String} location Country
 * @apiParam (Optional) {String} address
 * @apiParam (Optional) {String} phone
 *
 * @apiParamExample {json} Request-Example:
 *       {"name" : "test",
 *       "email" : "test@test.fr",
 *       "pwd" : "abcd",
 *       "birthday" : "01/01/2000",
 *       "location" : "france"}
 *
 * @apiError InvalidEmailException mail invalid
 * @apiError EmptyFieldException empty field on requested fields forbidden
 * @apiError BadGeographicLocationException need to be frensh
 * @apiError InvalidPhoneNumberException need to have a valid phone number (frensh number)
 * @apiError MinimumAgeRequiredException need to have more than 18
 */

/**
 * *
 * @api {get} /registered RegisteredUsers
 * @apiVersion 0.1.0
 * @apiDescription Get the users List
 * @apiName RegisteredUsers
 * @apiGroup UserControler
 *
 * @apiSuccessExample {json} Success-Response:
 *       {"content":[
 *       {"name":"test",
 *       "email":"test@test.fr",
 *       "pwd":"[secret]",
 *       "birthday":"01/01/2000",
 *       "location":"france",
 *       "address":"NULL",
 *       "phone":null}]}
 *
 */

/**
 * *
 * @api {get} /registered/:id GetUserFormId
 * @apiVersion 0.1.0
 * @apiDescription Get the user form his id
 * @apiName GetUserFormId
 * @apiGroup UserControler
 *
 * @apiParam {Number} id The player ID
 *
 * @apiSuccessExample {json} Success-Response:
 *       {"content":[
 *       {"name":"test",
 *       "email":"test@test.fr",
 *       "pwd":"[secret]",
 *       "birthday":"01/01/2000",
 *       "location":"france",
 *       "address":"NULL",
 *       "phone":null}]}
 *
 * @apiError UserNotFoundException User not found exception
 */



