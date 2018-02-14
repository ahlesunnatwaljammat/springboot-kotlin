package edu.learn.mongo.repos

import edu.learn.mongo.entities.User

interface UserRepo : MongoGenericRepo<User, String> {

}