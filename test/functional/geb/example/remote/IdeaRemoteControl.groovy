package geb.example.remote

import geb.example.Idea
import grails.plugin.remotecontrol.RemoteControl

class IdeaRemoteControl {
  RemoteControl remote = new RemoteControl()

  Idea createIdea(String title, String description) {
    remote {
      Idea idea = new Idea(
          title: title,
          description: description
      )

      idea.save()
    }
  }

  Idea findByTitle(String title) {
    remote {
      Idea.findByTitle(title)
    }
  }

  void deleteAllIdeas() {
    remote {
      Idea.list().each {
        it.delete()
      }
    }
  }

  void resetMockPatentService() {
    remote {
      ctx.patentService.reset()
    }
  }

  List<Idea> findIdeasSubmittedToPatentOffice() {
    remote {
      return ctx.patentService.ideasSentToPatentOffice
    }
  }
}
