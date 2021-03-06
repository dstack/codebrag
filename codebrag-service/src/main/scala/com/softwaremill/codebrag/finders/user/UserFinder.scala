package com.softwaremill.codebrag.finders.user

import com.softwaremill.codebrag.dao.user.UserDAO
import com.softwaremill.codebrag.domain.User
import com.typesafe.scalalogging.slf4j.Logging
import com.softwaremill.codebrag.finders.browsingcontext.UserBrowsingContextFinder


class UserFinder(userDao: UserDAO, userBrowsingContextFinder: UserBrowsingContextFinder) extends Logging {

  def findAllAsManagedUsers(): ManagedUsersListView = ManagedUsersListView(userDao.findAll().map(toManagedUser).sortBy(_.email))

  private def toManagedUser(user: User) = ManagedUserView(user.id, user.emailLowerCase, user.name, user.active, user.admin)

  def findLoggedInUser(user: User): LoggedInUserView = LoggedInUserView(user, userBrowsingContextFinder.findUserDefaultContext(user.id))

}